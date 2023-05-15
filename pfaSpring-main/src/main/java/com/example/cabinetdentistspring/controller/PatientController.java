
package com.example.cabinetdentistspring.controller;

import com.example.cabinetdentistspring.models.Patient;
import com.example.cabinetdentistspring.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PatientController {


    @Autowired
    PatientService service;


    @GetMapping("/allpatient")
    public String findAll(Model model) {
        model.addAttribute("patients", service.findallPatient());
        return "Patient";
    }

    @GetMapping("/add")
    public String lunchAddPatientPage(Model model) {
        model.addAttribute("patients", new Patient());
        return "add-Patient";
    }

    @PostMapping("/addPatient")
    public String createPatient(Patient patient) {
        service.addPatient(patient);
        return "redirect:/allpatient";

    }

    @GetMapping("/edit/{id}")
    public String lunchEditPage(Model model, @PathVariable("id") int id) {
        model.addAttribute("patients", service.findPatientById(id));
        return "edit-patient";

    }

    @PostMapping("/updatePatient")
    public String upadtePatient(Patient patient) {
        service.updatePatient(patient);


        return "redirect:/allpatient";
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/allpatient";
    }

}
