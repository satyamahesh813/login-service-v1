package org.swaroopwardhinee.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.swaroopwardhinee.request.EmailRequest;
import org.swaroopwardhinee.response.CustomResponse;

@FeignClient(name = "sendemail", url = "localhost:8080")
public interface EmailFeign {

	@RequestMapping(method = RequestMethod.POST, value = "/sendemail")
	ResponseEntity<CustomResponse> sendEmail(@RequestBody EmailRequest emailRequest);

}
