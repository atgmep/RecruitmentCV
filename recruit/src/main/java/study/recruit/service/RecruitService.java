package study.recruit.service;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import study.recruit.common.Methods;
import study.recruit.entity.TblApply;
import study.recruit.entity.TblRecruit;
import study.recruit.repository.ApplyRepository;
import study.recruit.repository.DepartmentRepository;
import study.recruit.repository.RecruitRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecruitService {
    private RecruitRepository recruitRepository;
    private DepartmentRepository departmentRepository;
    private ApplyRepository applyRepository;

    public RecruitService(RecruitRepository recruitRepository, DepartmentRepository departmentRepository, ApplyRepository applyRepository) {
        this.recruitRepository = recruitRepository;
        this.departmentRepository = departmentRepository;
        this.applyRepository = applyRepository;
    }

    public String getRecruitList(Gson gson) {
        List<TblRecruit> tblRecruits = recruitRepository.findAll();
        if (tblRecruits.isEmpty()) {
            return "empty";
        } else {
            List<String> strList = new ArrayList<>();
            for (TblRecruit tblRecruit : tblRecruits) {
                strList.add(gson.toJson(tblRecruit));
            }
            return String.join("|", strList);
        }
    }


    public String createRecruit(String name, String description, Double minSalary, Double maxSalary, Long applyFrom, Long applyTo, int departmentId) {
        TblRecruit tblRecruit = new TblRecruit();
        tblRecruit.setName(name);
        tblRecruit.setDescription(description);
        tblRecruit.setMinSalary(minSalary);
        tblRecruit.setMaxSalary(maxSalary);
        tblRecruit.setApplyFrom(applyFrom);
        tblRecruit.setApplyTo(applyTo);
        tblRecruit.setDepartment(departmentRepository.findById(departmentId).get());
        recruitRepository.save(tblRecruit);
        return "ok";
    }


    public String updateRecruit(int recruitId, String name, String description, Double minSalary, Double maxSalary, Long applyFrom, Long applyTo, int departmentId) {
        TblRecruit tblRecruit = recruitRepository.findById(recruitId).get();
        tblRecruit.setName(name);
        tblRecruit.setDescription(description);
        tblRecruit.setMinSalary(minSalary);
        tblRecruit.setMaxSalary(maxSalary);
        tblRecruit.setApplyFrom(applyFrom);
        tblRecruit.setApplyTo(applyTo);
        tblRecruit.setDepartment(departmentRepository.findById(departmentId).get());
        recruitRepository.save(tblRecruit);
        return "ok";
    }


    public String getApplyList(Gson gson, int recruitId) {
        Methods methods = new Methods();
        TblRecruit tblRecruit = recruitRepository.findById(recruitId).get();
        List<TblApply> tblApplies = applyRepository.findAllByRecruit(tblRecruit);
        if (tblApplies.isEmpty()) {
            return "empty";
        } else {
            List<String> strList = new ArrayList<>();
            for (TblApply tblApply : tblApplies) {
                strList.add(gson.toJson(tblApply));
            }
            return String.join("|", strList);
        }
    }
}
