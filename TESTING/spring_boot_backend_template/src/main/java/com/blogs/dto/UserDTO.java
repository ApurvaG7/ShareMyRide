package com.blogs.dto;
import com.blogs.pojo.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password; 
    private User.Role role;
    
    
 
    
    
    
}

























//@JsonProperty(access = Access.READ_ONLY) // used during serialization
//private Long id;
//@NotBlank
//private String firstName;
//@NotBlank
//private String lastName;
//@Email
//private String email;
//@JsonProperty(access = Access.WRITE_ONLY) //required only in de-ser.
//private String password;
//@JsonProperty(access = Access.WRITE_ONLY)
//private String confirmPassword;
//@DateTimeFormat(pattern = "yyyy-MM-dd")
//private LocalDate joinDate;
//
//