import com.amazonaws.services.ec2.*;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.StartInstancesRequest;



public class StartInstance {

    public static void startIns(AmazonEC2 ec2,String instance_id)
    {
        System.out.println("Start Instances");
        System.out.println("instance ID: "+ instance_id);

        StartInstancesRequest request=new StartInstancesRequest()
                .withInstanceIds(instance_id);

        ec2.startInstances(request);

        System.out.println("Start Instances");
        
        
    }
}