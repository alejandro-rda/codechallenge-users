/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.27).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.User;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-08-16T12:23:29.770Z")

@Validated
@Api(value = "createUsers", description = "the createUsers API")
@RequestMapping(value = "/users")
public interface CreateUsersApi {

    @ApiOperation(value = "", nickname = "createUsersPost", notes = "", response = User.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "CREATED", response = User.class),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/createUsers",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<User> createUsersPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody User user);

}
