package com.ctu.chemis.Service;

import com.ctu.chemis.DTO.SalaryDTO;
import com.ctu.chemis.Repository.SalaryRepository;
import com.ctu.chemis.execption.NotFoundException;
import com.ctu.chemis.mapper.SalaryMapper;
import com.ctu.chemis.model.Salary;
import lombok.RequiredArgsConstructor;
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


    public SalaryDTO getSingleSalary(long salaryId) {

        Salary salary = salaryRepository.findById(salaryId).orElseThrow(
                () -> new NotFoundException("Salary id not found: " + salaryId)
        );

        return salaryMapper.toSalaryDTO(salary);
    }
}
