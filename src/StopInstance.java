import com.amazonaws.services.ec2.*;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.StopInstancesRequest;


public class StopInstance {

    public static void stopInstance(AmazonEC2 ec2, String instanceid)
    {
		StopInstancesRequest request = new StopInstancesRequest().withInstanceIds(instanceid);
		ec2.stopInstances(request);
		System.out.printf("Instanceid: %s",instanceid);
		System.out.println("Stop success");
    }
}