package com.example.finalproject;

import com.example.finalproject.Api.ApiException;
import com.example.finalproject.Model.Orders;
import com.example.finalproject.Model.User;
import com.example.finalproject.Repository.AuthRepository;
import com.example.finalproject.Repository.OrdersRepository;
import com.example.finalproject.Service.OrdersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrdersServiceTest {

//    @InjectMocks
//    OrdersService ordersService;
//     @Mock
//    OrdersRepository
//    @Mock
//    AuthRepository authRepository;
//
//    private User user;
//    private Orders order;
//
//    @BeforeEach
//    void setUp() {
//        user = new User(1, "username", "password", "role"); // Replace with your User constructor
//        order = new Orders(1, "PENDING", user); // Replace with your Orders constructor
//    }
//
//    @org.junit.Test
//    void changeOrderStatus_UserNotFound() {
//        when(userRepository.findUserById(1)).thenReturn(null);
//
//        ApiException exception = assertThrows(ApiException.class, () ->
//                yourService.changeOrderStatus(1, 1, "shipped")
//        );
//        assertEquals("User not found", exception.getMessage());
//    }
//
//    @Test
//    void changeOrderStatus_OrderNotFound() {
//        when(userRepository.findUserById(1)).thenReturn(user);
//        when(ordersRepository.findOrdersById(1)).thenReturn(null);
//
//        ApiException exception = assertThrows(ApiException.class, () ->
//                yourService.changeOrderStatus(1, 1, "shipped")
//        );
//        assertEquals("Order Not Found", exception.getMessage());
//    }
//
//    @Test
//    void changeOrderStatus_Success() {
//        when(userRepository.findUserById(1)).thenReturn(user);
//        when(ordersRepository.findOrdersById(1)).thenReturn(order);
//
//        String result = yourService.changeOrderStatus(1, 1, "shipped");
//
//        assertEquals("Order Status Changed Successfully", result);
//        verify(ordersRepository, times(1)).save(order);
//        assertEquals("shipped", order.getStatus());
//    }
}
