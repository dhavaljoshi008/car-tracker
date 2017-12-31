/**
 * ReadingController.java
 * app.djxlab.cartracker.api.controller 
 *
 * @author: Dhaval Joshi.
 */
package app.djxlab.cartracker.api.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.djxlab.cartracker.api.entity.Reading;
import app.djxlab.cartracker.api.service.ReadingService;

@RestController
public class ReadingController {

	private ReadingService readingService;
	
	public ReadingController(ReadingService readingService) {
		this.readingService = readingService;
	}
	
    @CrossOrigin(origins = "http://mocker.egen.io")
	@RequestMapping(value = "/readings", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Reading postReading(@RequestBody Reading reading) {
		return readingService.insert(reading);
	}
}
