## Mind Feed

### Possible Directions

#### Assumptions/Expectations
* PowerPoint files will be relatively small
* PowerPoint can have multiple slides to process
* How frequent is delivery?
* Is there an SLA associated with the processed data?
* What volume of data is expected?

  
#### Trigger at intervals, processing all new files in parallel

* Serverless with Lambda functions and
  [Step Functions Distributed Map]
  (https://aws.amazon.com/blogs/aws/step-functions-distributed-map-a-serverless-solution-for-large-scale-parallel-data-processing/)

#### Trigger from s3 when new file uploaded


### Cross-cutting
#### Monitoring
* structured logging - 

#### Security
* IAM best practice
  * for development
  * for deploy, ci/cd
  * for 

#### Performance
