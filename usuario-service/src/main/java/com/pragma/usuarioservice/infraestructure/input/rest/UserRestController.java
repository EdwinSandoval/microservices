package com.pragma.usuarioservice.infraestructure.input.rest;

import com.pragma.usuarioservice.application.dto.request.UserRequestDto;
import com.pragma.usuarioservice.application.dto.response.UserResponseDto;
import com.pragma.usuarioservice.application.handler.IUserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserRestController {

    private final IUserHandler userHandler;

//    @Operation(summary = "Add a new object")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "201", description = "Object created", content = @Content),
//            @ApiResponse(responseCode = "409", description = "Object already exists", content = @Content)
//    })
    @PostMapping("/guardar_usuario")
    public ResponseEntity<UserResponseDto> saveUser(@RequestBody UserRequestDto userRequestDto) {
//        userHandler.saveUsers(userRequestDto);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
        return new ResponseEntity<>(userHandler.saveUsers(userRequestDto),HttpStatus.CREATED);
    }

//    @Operation(summary = "Get all objects")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "All objects returned",
//                    content = @Content(mediaType = "application/json",
//                            array = @ArraySchema(schema = @Schema(implementation = ObjectResponseDto.class)))),
//            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
//    })
    @GetMapping("/listar_usuario")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {

        return ResponseEntity.ok(userHandler.getAllUsers());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<UserResponseDto> getUserId(@PathVariable(name = "id") Long userId){
        return ResponseEntity.ok(userHandler.getUserId(userId));
    }


}
