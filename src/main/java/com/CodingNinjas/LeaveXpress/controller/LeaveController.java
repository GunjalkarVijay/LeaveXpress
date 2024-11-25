package com.CodingNinjas.LeaveXpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.CodingNinjas.LeaveXpress.dto.LeaveDto;
import com.CodingNinjas.LeaveXpress.model.LeaveModel;
import com.CodingNinjas.LeaveXpress.service.LeaveService;

@RestController
@RequestMapping("/api/leave")
public class LeaveController {

	@Autowired
	LeaveService service;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
	public LeaveModel getById(@PathVariable Long id) {
		return service.getById(id);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/all")
	public List<LeaveModel> getAll(){
		return service.getAll();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/accepted")
	public List<LeaveModel> getAllAccepted(){
		return service.getAllAccepted();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/rejected")
	public List<LeaveModel> getAllRejected(){
		return service.getAllRejected();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/status/{id}")
	public boolean statusById(@PathVariable Long id) {
		return service.statusById(id);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/{id}")
	public void updateLeave(@PathVariable Long id, @RequestBody LeaveDto updatedLeave) {
		service.updateLeave(id, updatedLeave);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		service.deleteById(id);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/apply")
	public void applyLeave(@RequestBody LeaveDto leaveRequest) {
		service.applyLeave(leaveRequest);
	}
	
	@PreAuthorize("hasRole('MANAGER')")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping("/accept/{id}")
	public void acceptLeave(@PathVariable Long id) {
		service.acceptLeave(id);
	}
	
	@PreAuthorize("hasRole('MANAGER')")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/reject/{id}")
	public void rejectLeave(@PathVariable Long id) {
		service.rejectLeave(id);
	}
	
	
}
