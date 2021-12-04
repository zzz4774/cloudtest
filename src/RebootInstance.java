import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.RebootInstancesRequest;
import com.amazonaws.services.ec2.model.RebootInstancesResult;

public class RebootInstance {
	
	
    public static void rebootInstance(AmazonEC2 ec2, String instanceid)
    {
    	RebootInstancesRequest request = new RebootInstancesRequest().withInstanceIds(instanceid);
    	RebootInstancesResult response = ec2.rebootInstances(request);
    	ec2.rebootInstances(request);
        System.out.println("Reboot Instances");
    }
}
