import java.sql.*;
import java.util.Scanner;
public class Reciepe {

    public static void main(String args[])
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reciepedb","root","");
        }
        catch (Exception e){
            System.out.println(e);
        }
        int choice;
        String name,category,taste;                       ;
        int price;
        Scanner s= new Scanner(System.in);
        while(true){
            System.out.println("1.select any option");
            System.out.println("1.insert");
            System.out.println("2.select");
            System.out.println("3.search");
            System.out.println("4.update");
            System.out.println("5.delete");
            System.out.println("6.exit");
            System.out.println("enter the choice");
            choice = s.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("enter recipe name");
                    name=s.next();
                    System.out.println("enter category");
                    category=s.next();
                    System.out.println("enter taste");
                    taste=s.next();
                    System.out.println("enter price");
                    price=s.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reciepedb","root","");
                        String sql="INSERT INTO `reciepe`(`name`, `category`, `taste`, `price`) VALUES (?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setString(1,name);
                        stmt.setString(2,category);
                        stmt.setString(3,taste);
                        stmt.setInt(4,price);
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                case 2:
                    System.out.println("select data");
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reciepedb","root","");
                        String sql="SELECT  `name`, `category`, `taste`, `price` FROM `reciepe` ";
                        Statement stmt = con.createStatement();
                        ResultSet rs= stmt.executeQuery(sql);
                        while (rs.next()){
                            String getname=rs.getString("name");
                            String getcategory=rs.getString("category");
                            String gettaste=rs.getString("taste");
                            String getprice=rs.getString("price");
                            System.out.println("recipename="+getname);
                            System.out.println("preparedby="+getcategory);
                            System.out.println("ingredients="+gettaste);
                            System.out.println("price="+getprice);
                        }

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 3:
                    System.out.println("search data");

                    break;
                case 4:
                    System.out.println("update data");
                case 5:
                    System.out.println("delete data");

                    break;
                case 6:
                    System.out.println("exit");
                    break;
            }
        }
    }
}

