package com.foodparcel.entity;

/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

public class Job {
    private String jobTitle, jobNumber;

    private Job(){}

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
    }
}

