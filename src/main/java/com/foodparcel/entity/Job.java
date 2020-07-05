package com.foodparcel.entity;

public class Job {
    private String jobTitle, department;

    public Job(JobBuilder jobBuilder) {
        this.jobTitle = jobBuilder.jobTitle;
        this.department = jobBuilder.department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobTitle='" + jobTitle + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public static class JobBuilder{
        private String jobTitle, department;

        public JobBuilder(String jobTitle, String department) {
            this.jobTitle = jobTitle;
            this.department = department;
        }

        public JobBuilder setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }

        public JobBuilder setDepartment(String department) {
            this.department = department;
            return this;
        }

        public JobBuilder copy(Job job){
            this.jobTitle = job.jobTitle;
            this.department = job.department;
            return this;
        }

        public Job build(){
            return new Job(this);
        }
    }
}

