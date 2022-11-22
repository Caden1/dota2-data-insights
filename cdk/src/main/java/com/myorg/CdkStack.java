package com.myorg;

import software.constructs.Construct;

import java.util.List;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.Vpc;
import software.amazon.awscdk.services.ec2.SubnetConfiguration;
// import software.amazon.awscdk.Duration;
// import software.amazon.awscdk.services.sqs.Queue;
import software.amazon.awscdk.services.ec2.SubnetType;

public class CdkStack extends Stack {
    public CdkStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public CdkStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        // The code that defines your stack goes here

        // example resource
        // final Queue queue = Queue.Builder.create(this, "CdkQueue")
        //         .visibilityTimeout(Duration.seconds(300))
        //         .build();

        Vpc.Builder.create(this, "MainVPC")
            .maxAzs(2)
            .subnetConfiguration(List.of(SubnetConfiguration.builder()
                .cidrMask(24)
                .name("public-subnet")
                .subnetType(SubnetType.PUBLIC)
                .build()))
        .build();
    }
}
