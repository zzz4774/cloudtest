import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import java.util.Scanner;


public class Main {

    public static void  main(String[] args) throws Exception {


        final AmazonEC2 ec2= AmazonEC2ClientBuilder.defaultClient();
        int menu_num;
        String instance_id;
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
            System.out.println("  1. list instance                2. available zones         ");
            System.out.println("  3. start instance               4. available regions      ");
            System.out.println("  5. stop instance                6. create instance        ");
            System.out.println("  7. reboot instance              8. list images            ");
            System.out.println("  9. describe my acc              99. quit                   ");
            System.out.println("------------------------------------------------------------");
            System.out.print("Enter an integer: ");
            menu_num=num.nextInt();
            
            //List Instance
            if(menu_num==1)
            {
            	System.out.println("List Instance");
            	ListInstance.listInstance(ec2);
            	System.out.println("Finish");
            }

            else if(menu_num==2)
            {
            	AvailableZones.availableZone(ec2);
            	
            }
            else if(menu_num==3)
            {
            	System.out.println("Put your instance Id");
            	instance_id=id.nextLine();
            	StartInstance.startIns(ec2,instance_id);
            }
            else if(menu_num==4)
            {
            	AvailableRegions.availableRegions(ec2);
            }
            else if(menu_num==5)
            {
            	System.out.println("Put your instance Id");
            	instance_id=id.nextLine();
            	StopInstance.stopInstance(ec2,instance_id);
            }
            //MakeInstance
            else if(menu_num==6)
            {
            	System.out.println("You'll make Instance");
            	MakeInstance.makeInstance(ec2);
            	
            }
            //RebootInstance
            else if(menu_num==7) {
                System.out.println("Put your instance Id");
                instance_id = id.nextLine();
                RebootInstance.rebootInstance(ec2, instance_id);
            }
            //list Images
            else if(menu_num==8)
            {
            	ListImages.listImages(ec2);
            }
            //Describe Accounts
            else if(menu_num==9)
            {
            	DescribeAccounts.describeAccounts(ec2);
            	System.out.println("Complete");
            }
            //Quit
            else if(menu_num==99)
            {
            	break;
            }
        }
        

    }
}
