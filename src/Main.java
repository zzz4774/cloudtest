import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import java.util.ListIterator;
import java.util.Scanner;
import com.amazonaws.services.ec2.model.*;
import java.util.List;
import com.amazonaws.services.ec2.*;
import com.amazonaws.services.ec2.model.MonitorInstancesRequest;
import com.amazonaws.services.ec2.model.UnmonitorInstancesRequest;

public class Main {
    public static void  main(String[] args) throws Exception {


        final AmazonEC2 ec2= AmazonEC2ClientBuilder.defaultClient();
        int menu_num;
        String instance_id;
        String instance_id2;
        String instance_id3;
        String instance_id4;
        String instance_id5;
        Scanner num = new Scanner(System.in);
        Scanner id = new Scanner(System.in);
        
        while(true)
        {
            System.out.println("                                                            ");
            System.out.println("                                                            ");
            System.out.println("------------------------------------------------------------");
            System.out.println("           Amazon AWS Control Panel using SDK               ");
            System.out.println("                                                            ");
            System.out.println("  Cloud Computing, Computer Science Department              ");
            System.out.println("                           at Chungbuk National University  ");
            System.out.println("------------------------------------------------------------");
            System.out.println("  1. list instance                2. available zones        ");
            System.out.println("  3. start instance               4. available regions      ");
            System.out.println("  5. stop instance                6. create instance        ");
            System.out.println("  7. reboot instance              8. list images            ");
            System.out.println("  9. describe my acc             10. monitor instance      ");
            System.out.println(" 11. unmonitor instance          99. quit                  ");
            System.out.println("------------------------------------------------------------");
            System.out.print("Enter an integer: ");
            menu_num=num.nextInt();


            if(menu_num==1)
            {
            	System.out.println("List Instance");
                boolean done=false;
                DescribeInstancesRequest request= new DescribeInstancesRequest();

                while(!done)
                {
                    System.out.println("Listing instances....");
                    DescribeInstancesResult response = ec2.describeInstances(request);
                    for(Reservation reservation: response.getReservations())
                    {
                        for(Instance instance: reservation.getInstances())
                        {
                            System.out.printf(
                                    "[id] %s, " +
                                            "[AMI] %s, " +
                                            "[type] %s, " +
                                            "[state] %s, " +
                                            "[monitoring state] %s\n",
                                    instance.getInstanceId(),
                                    instance.getImageId(),
                                    instance.getInstanceType(),
                                    instance.getState().getName(),
                                    instance.getMonitoring().getState());
                        }
                    }
                    request.setNextToken(response.getNextToken());
                    if(response.getNextToken()==null)
                    {
                        done=true;
                    }
                }
            	System.out.println("Finish");
            }

            else if(menu_num==2)
            {
                DescribeAvailabilityZonesResult zones_response = ec2.describeAvailabilityZones();
                for(AvailabilityZone zone : zones_response.getAvailabilityZones()) {
                    System.out.printf(
                            "List zone %s " +
                                    "with status %s " +
                                    "in region %s \n",
                            zone.getZoneName(),
                            zone.getState(),
                            zone.getRegionName());
                }
                System.out.println("List Success");
            	
            }
            else if(menu_num==3)
            {
            	System.out.println("Put your instance Id");
            	instance_id=id.nextLine();
                System.out.println("Start Instances");
                System.out.println("instance ID: "+ instance_id);
                StartInstancesRequest request=new StartInstancesRequest().withInstanceIds(instance_id);
                ec2.startInstances(request);
                System.out.println("Start Success");
            }
            else if(menu_num==4)
            {
                DescribeRegionsResult regions_response = ec2.describeRegions();
                for(Region region : regions_response.getRegions()) {
                    System.out.printf(
                            "List region %s " +
                                    "with endpoint %s \n",
                            region.getRegionName(),
                            region.getEndpoint());
                }
                System.out.println("List Success");
            }
            else if(menu_num==5)
            {
            	System.out.println("Put your instance Id");
            	instance_id2=id.nextLine();
                StopInstancesRequest request = new StopInstancesRequest().withInstanceIds(instance_id2);
                ec2.stopInstances(request);
                System.out.printf("Instance ID: %s",instance_id2);
                System.out.println("Stop success");
            }
            else if(menu_num==6)
            {
            	System.out.println("Put AMI ID :");
                Scanner ami=new Scanner(System.in);

                String ami_id;
                ami_id=ami.nextLine();
                RunInstancesRequest run_request=new RunInstancesRequest().withImageId(ami_id).withInstanceType(InstanceType.T2Micro).withMaxCount(1).withMinCount(1);
                RunInstancesResult run_response=ec2.runInstances(run_request);
                String reservation_id=run_response.getReservation().getInstances().get(0).getInstanceId();
                System.out.println(reservation_id);
            	
            }
            else if(menu_num==7) {
                System.out.println("Put your instance Id");
                instance_id3 = id.nextLine();
                RebootInstancesRequest request = new RebootInstancesRequest().withInstanceIds(instance_id3);
                ec2.rebootInstances(request);
                System.out.println("Reboot Instance Success");
            }
            else if(menu_num==8)
            {
                DescribeImagesRequest request = new DescribeImagesRequest().withOwners("self");
                DescribeImagesResult response = ec2.describeImages(request);
                System.out.println("list images");
                List<Image> images = response.getImages();

                if (images.isEmpty()) {
                    System.out.println("Empty");
                }
                else
                {
                    for(Image image:images)

                        System.out.println(image.getImageId());
                    System.out.println("\n");
                }
                System.out.println("Success");
            }
            else if(menu_num==9)
            {
                try{
                    DescribeAccountAttributesResult accountResults = ec2.describeAccountAttributes();
                    List<AccountAttribute> accountList = accountResults.getAccountAttributes();
                    for (ListIterator iter = accountList.listIterator(); iter.hasNext(); ) {
                        AccountAttribute attribute = (AccountAttribute) iter.next();
                        System.out.print("\n Attribute name : "+attribute.getAttributeName());
                        List<AccountAttributeValue> values = attribute.getAttributeValues();

                        for (ListIterator iterVals = values.listIterator(); iterVals.hasNext(); ) {
                            AccountAttributeValue myValue = (AccountAttributeValue) iterVals.next();
                            System.out.print("\n Value : "+myValue.getAttributeValue());
                        }
                    }
                }
                catch (Exception e)
                {
                    e.getStackTrace();
                }
            	System.out.println("Complete");
            }
            else if(menu_num==10)
            {
                System.out.println("Put your instance Id");
                instance_id4 = id.nextLine();
                MonitorInstancesRequest request = new MonitorInstancesRequest().withInstanceIds(instance_id4);
                ec2.monitorInstances(request);
                System.out.print("Monitor Success");
            }
            else if(menu_num==11)
            {
                System.out.println("Put your instance Id");
                instance_id5 = id.nextLine();
                UnmonitorInstancesRequest request = new UnmonitorInstancesRequest().withInstanceIds(instance_id5);
                ec2.unmonitorInstances(request);
                System.out.println("Unmonitor Success");
            }
            else if(menu_num==99)
            {
            	break;
            }
        }
        

    }
}
