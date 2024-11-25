package com.CodingNinjas.LeaveXpress.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CodingNinjas.LeaveXpress.dto.LeaveDto;
import com.CodingNinjas.LeaveXpress.exception.LeaveNotFoundException;
import com.CodingNinjas.LeaveXpress.model.LeaveModel;
import com.CodingNinjas.LeaveXpress.repository.LeaveRepository;

@Service
public class LeaveService {

	@Autowired
	LeaveRepository repo;

	public LeaveModel getById(Long id) {
		return repo.findById(id).orElseThrow(()-> new LeaveNotFoundException("Leave not found with given id"));
	}

	public List<LeaveModel> getAll() {
		return repo.findAll();
	}

	public List<LeaveModel> getAllAccepted() {
		// TODO Auto-generated method stub
		return repo.findAllByIsAcceptedTrue();
	}

	public List<LeaveModel> getAllRejected() {
		return repo.findAllByIsAcceptedFalse();
	}

	public boolean statusById(Long id) {
		LeaveModel leave = getById(id);
//		String status;
//		if(Objects.isNull(leave.isAccepted())) {
//			status = "PENDING";
//		}else if(leave.isAccepted()) {
//			status = "ACCEPTED";
//		}else {
//			status = "REJECTED";
//		}
//		return status;
		return leave.isAccepted();
	}

	public void updateLeave(Long id, LeaveDto updatedLeave) {
		LeaveModel leave = getById(id);
		leave.setDescription(updatedLeave.getDescription());
		leave.setEndDate(updatedLeave.getEndDate());
		leave.setStartDate(updatedLeave.getStartDate());
		leave.setType(updatedLeave.getType());
		repo.save(leave);
	}

	public void deleteById(Long id) {
		repo.deleteById(id);
	}

	public void applyLeave(LeaveDto leaveRequest) {
		LeaveModel leave = new LeaveModel();
		leave.setDescription(leaveRequest.getDescription());
		leave.setType(leaveRequest.getType());
		leave.setEndDate(leaveRequest.getEndDate());
		leave.setStartDate(leaveRequest.getStartDate());
		repo.save(leave);
	}

	public void acceptLeave(Long id) {
		LeaveModel leave = getById(id);
		leave.setAccepted(true);
		repo.save(leave);
	}

	public void rejectLeave(Long id) {
		LeaveModel leave = getById(id);
		leave.setAccepted(false);
		repo.save(leave);
	}
	
	
}
