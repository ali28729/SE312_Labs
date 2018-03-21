import java.util.Scanner;

public class invoker {

    private static final int STUDENTS = 6;
    private static final int PROP = 3;
    
	public static void main(String[] args) {

		String repo[][]= new String[STUDENTS][PROP];
		double sum=0;
		Scanner input=new Scanner(System.in);
		
		for(int i = 0; i < STUDENTS; i++) {
			//Name
			System.out.println("\nProvide credentials of Student " + Integer.toString(i+1) +":");
			System.out.print("Name:\t\t");
			repo[i][0] = input.nextLine();
			
			//Registration Number
			System.out.print("Reg. No.:\t");
			int regNo=Integer.parseInt(input.nextLine());			
			while(true){
				boolean found=false;
				for(int j = 0; j < i; j++) {
					if(regNo==Integer.parseInt(repo[j][1])){
						found=true;
						break;
					}
				}
				if(!found)
					break;
				else {
					System.out.print("Reg No Already Exists, Please enter again:\t");
					regNo=Integer.parseInt(input.nextLine());
				}
			}
			repo[i][1] = String.valueOf(regNo);

			//CGPA
			double cgpa = 0;
			do{
				System.out.print("CGPA:\t");
				cgpa = Double.parseDouble(input.nextLine());
				if(cgpa < 0 || cgpa > 4)
					System.out.println("Invalid CGPA\n Please enter again");
			}while(cgpa < 0 || cgpa > 4);
			repo[i][2] = String.valueOf(cgpa);
		}
		
		
		for(int i=0;i<STUDENTS;i++) {
			sum += Double.parseDouble(repo[i][2]);
		}
		double avg = sum/STUDENTS;
		double min = Double.MAX_VALUE;
		double max = 0;
		
		for(int i=0;i<STUDENTS;i++) {
			double blob = Double.parseDouble(repo[i][2]);
			if(blob < min)
				min = blob;
			if(max < blob)
				max =  blob;
		}
		
		System.out.println("\n\n\t\t\tSummary\n");
		System.out.println("\t>>Average CGPA:" + String.valueOf(avg) + "\t");
		System.out.println("\t>>Minimum CGPA:" + String.valueOf(min) + "\t");
		System.out.println("\t>>Maximum CGPA:" + String.valueOf(max) + "\t");
		System.out.println("\n>Detailed Data:");
		
		for(int i=0; i<STUDENTS; i++)
		{
			System.out.println("Person " + (i+1) + ": ");
			System.out.println("\tName: " + repo[i][0]);
			System.out.println("\tReg. No: " + repo[i][1]);
			System.out.println("\tCGPA: " + repo[i][2]);
		}

		
		System.out.println("\n>>Students with CGPA < Average:");
		for(int i=0; i<STUDENTS; i++)
		{
			if(Double.parseDouble(repo[i][2]) >= avg)
				continue;
			System.out.println("Person " + (i+1) + ": ");
			System.out.println("\tName: " + repo[i][0]);
			System.out.println("\tReg. No: " + repo[i][1]);
			System.out.println("\tCGPA: " + repo[i][2]);
		}
		
		System.out.println("\n\n>>Search by:\n1:Name\n2:Reg. No");
		int option = 0;
		
		while(option != 1 && option != 2)
		{
			option = Integer.parseInt(input.nextLine());
			if(option == 1)
			{
				System.out.print("Enter name:\t");
				String name = input.nextLine();
				for(int i=0; i<STUDENTS; i++)
				{
					if(!name.equals(repo[i][0]))
						continue;
					System.out.println("Person " + (i+1) + ": ");
					System.out.println("\tName: " + repo[i][0]);
					System.out.println("\tReg. No: " + repo[i][1]);
					System.out.println("\tCGPA: " + repo[i][2]);
					break;
				}
			}
			else if (option == 2)
			{
				System.out.print("Enter Reg. No:\t");
				String regNo = input.nextLine();
				for(int i=0; i<STUDENTS; i++)
				{
					if(!regNo.equals(repo[i][1]))
						continue;
					System.out.println("Person " + (i+1) + ": ");
					System.out.println("\tName: " + repo[i][0]);
					System.out.println("\tReg. No: " + repo[i][1]);
					System.out.println("\tCGPA: " + repo[i][2]);
					break;
				}
			}
			else
			{
				System.out.println("Invalid Option!");
				System.out.println("\n\nSearch by:\n\t1:Name\n\t2:Reg. No");
			}
		}
		input.close();
	}

}


