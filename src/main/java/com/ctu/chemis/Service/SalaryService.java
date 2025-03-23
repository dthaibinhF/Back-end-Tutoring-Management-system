package com.ctu.chemis.Service;

import com.ctu.chemis.DTO.SalaryDTO;
import com.ctu.chemis.Repository.SalaryRepository;
import com.ctu.chemis.execption.MissMatchException;
import com.ctu.chemis.execption.NotFoundException;
import com.ctu.chemis.mapper.SalaryMapper;
import com.ctu.chemis.model.Salary;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SalaryService {
    private final SalaryRepository salaryRepository;
    private final SalaryMapper salaryMapper;

    public List<SalaryDTO> getAllSalary() {
        return salaryRepository.findAll()
                .stream()
                .map(salaryMapper::toSalaryDTO)
                .collect(Collectors.toList());
    }


    public ResponseEntity<SalaryDTO> getSingleSalary(long salaryId) {

        Salary salary = salaryRepository.findById(salaryId).orElseThrow(
                () -> new NotFoundException("Salary id not found: " + salaryId)
        );

        return ResponseEntity.ok(salaryMapper.toSalaryDTO(salary));
    }

    public ResponseEntity<SalaryDTO> updateSalary(SalaryDTO salaryDTO, long salaryId) {

        Salary salary = salaryRepository.findById(salaryId).orElseThrow(
                () -> new NotFoundException("Salary id not found: " + salaryId)
        );

        if (salaryDTO.getId() != salary.getId()) {
            throw new MissMatchException("Salary id mismatch: " + salaryId);
        }

        salaryMapper.updateFromDTO(salary, salaryDTO);

        return ResponseEntity.ok(salaryMapper.toSalaryDTO(salaryRepository.save(salary)));
    }

    public ResponseEntity<String> deleteSalary(long salaryId) {

        salaryRepository.findById(salaryId).orElseThrow(
                () -> new NotFoundException("Salary id not existed: " + salaryId)
        );

        salaryRepository.deleteById(salaryId);
        if (salaryRepository.existsById(salaryId)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Salary not deleted");
        } else return ResponseEntity.ok("Salary deleted successfully");
    }

    public ResponseEntity<SalaryDTO> createSalary(SalaryDTO salaryDTO) {
        Salary salary = salaryMapper.toSalary(salaryDTO);
        salary.setId(0);
        Salary savedSalary = salaryRepository.save(salary);
        return ResponseEntity.status(HttpStatus.CREATED).body(salaryMapper.toSalaryDTO(savedSalary));
    }
}
