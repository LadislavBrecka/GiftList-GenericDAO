package com.satori.giftlist.restControllers;

import com.satori.giftlist.domain.Gift;
import com.satori.giftlist.service.api.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GiftRestController {

    @Autowired
    private GiftService giftService;

    @GetMapping("/gift")
    public ResponseEntity getAll (){
        List<Gift> giftList = giftService.getAll();
        if(giftList != null){
            return new ResponseEntity<>(giftList, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/gift/{id}")
    public ResponseEntity getById(@PathVariable int id){
        Gift gift = giftService.getById(id);
        if(gift != null){
            return new ResponseEntity<>(gift, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/gift")
    public ResponseEntity create(@RequestBody Gift gift){
        giftService.create(gift);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/gift/{id}")
    public ResponseEntity update(@RequestBody Gift gift, @PathVariable int id){
        if(giftService.getById(id) != null){
            giftService.update(id, gift);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        }
    }

    @DeleteMapping("/gift/{id}")
    public ResponseEntity delete(@PathVariable int id){
        if(giftService.getById(id) != null) {
            giftService.delete(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        }
    }
}
