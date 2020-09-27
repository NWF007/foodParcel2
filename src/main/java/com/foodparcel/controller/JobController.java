package com.foodparcel.controller;

import com.foodparcel.Service.impl.JobServiceImpl;
import com.foodparcel.entity.Job;
import com.foodparcel.factory.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobServiceImpl jobService;

    @PostMapping("/create")
    public Job create(@RequestBody Job job){
        //Job newJob = JobFactory.createJob(job.getJobTitle());
        return jobService.create(job);
    }

    @GetMapping(path = "/read/{id}")
    public Job read(@PathVariable String id){
        return jobService.read(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Job job){
        jobService.update(job);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        jobService.delete(id);
    }

    @GetMapping("/all")
    public Set<Job> getAll(){
        return jobService.getAll();
    }
}
