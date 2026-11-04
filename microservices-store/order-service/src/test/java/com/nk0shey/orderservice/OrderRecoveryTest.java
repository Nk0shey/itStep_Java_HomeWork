package com.nk0shey.orderservice;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DataAccessResourceFailureException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderRecoveryTest {
    @Test void retryUsesSameReservationAfterLocalDatabaseFailure() {
        var repository = mock(OrderRepository.class);
        var products = mock(ProductClient.class);
        var service = new OrderService(repository, products);
        String key = UUID.randomUUID().toString();
        when(repository.findById(key)).thenReturn(Optional.empty());
        when(products.reserve(key, 1L, 2)).thenReturn(
            new ProductClient.Reservation(key, 1L, 2, "Book", new BigDecimal("12.50")));
        when(repository.saveAndFlush(any(OrderRecord.class)))
            .thenThrow(new DataAccessResourceFailureException("simulated database outage"))
            .thenAnswer(call -> call.getArgument(0));
        assertThrows(DataAccessResourceFailureException.class, () -> service.create(key, 1L, 2));
        OrderRecord order = service.create(key, 1L, 2);
        assertEquals(key, order.id);
        assertEquals(new BigDecimal("25.00"), order.total);
        verify(products, times(2)).reserve(key, 1L, 2);
    }
}
