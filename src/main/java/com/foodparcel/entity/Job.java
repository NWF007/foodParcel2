package com.foodparcel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

@Entity
public class Job {

    @Id
    private String jobNumber;
    private String jobTitle;

    protected Job(){}

    public Job(JobBuilder jobBuilder) {
        this.jobTitle = jobBuilder.jobTitle;
        this.jobNumber = jobBuilder.jobNumber;
    }

    public String getJobNumber() { return jobNumber; }

    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public String toString() {
        return "Job {\n" +
                "jobNumber='" + jobNumber + '\'' +
                ", \njobTitle='" + jobTitle + '\'' + "\n"+
                '}';
    }

    public static class JobBuilder{
        private String jobTitle, jobNumber;

        public JobBuilder() {
        }

        public JobBuilder setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }

        public JobBuilder setJobNumber(String jobNumber) {
            this.jobNumber = jobNumber;
            return this;
        }

        public JobBuilder copy(Job job){
            this.jobTitle = job.jobTitle;
            this.jobNumber = job.jobNumber;
            return this;
        }

        public Job build(){
            return new Job(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            JobBuilder that = (JobBuilder) o;
            return Objects.equals(jobTitle, that.jobTitle) &&
                    jobNumber.equals(that.jobNumber);
        }

        @Override
        public int hashCode() {
            return Objects.hash(jobNumber);
        }
    }
}

