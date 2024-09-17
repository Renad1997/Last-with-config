package com.example.finalproject.Controller;

import com.example.finalproject.Api.ApiResponse;
import com.example.finalproject.Model.Student;
import com.example.finalproject.Model.UsedItem;
import com.example.finalproject.Model.User;
import com.example.finalproject.Service.UsedItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/usedItem")
public class UsedItemController {

    private final UsedItemService usedItemService;

    @GetMapping("/get")
    public ResponseEntity getAllUsedItem() {
        return ResponseEntity.status(200).body(usedItemService.getAllUsedItem());
    }

    @PostMapping("/add/{sellerId}")
    public ResponseEntity<String> addUsedItem(@RequestBody @Valid UsedItem usedItem, @PathVariable Integer sellerId) {
        usedItemService.addUsedItem(usedItem, sellerId);
        return ResponseEntity.ok("Used item added successfully");
    }

    @PutMapping("/update/{usedItem_id}")
    public ResponseEntity updateUsedItem(@AuthenticationPrincipal User user,@PathVariable Integer usedItem_id,@Valid @RequestBody UsedItem usedItem) {
        usedItemService.updateUsedItem(user.getId(),usedItem_id, usedItem);
        return ResponseEntity.status(200).body(new ApiResponse("Used item updated successfully"));
    }

    @DeleteMapping("/delete/{usedItem_id}")
    public ResponseEntity deleteUsedItem(@AuthenticationPrincipal User user,@PathVariable Integer usedItem_id) {
        usedItemService.deleteUsedItem(user.getId(),usedItem_id);
        return ResponseEntity.status(200).body(new ApiResponse("Used item deleted successfully"));
    }

    @PostMapping("/buy/{itemId}/{buyerId}")
    public ResponseEntity buyUsedItem(@PathVariable Integer itemId, @PathVariable Integer buyerId) {
        usedItemService.buyUsedItem(itemId, buyerId);
        return ResponseEntity.status(200).body("Used item bought");
    }

    @GetMapping("/seller/{id}")
    public ResponseEntity getItemsBySeller(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(usedItemService.getItemsBySeller(id));
    }


}
