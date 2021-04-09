/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_3.part_2;


public class Cities {
    private String City_ID;
    private String City_Name;

    public Cities(String City_ID, String City_Name) {
        this.City_ID = City_ID;
        this.City_Name = City_Name;
    }

    public String getCity_ID() {
        return City_ID;
    }

    public void setCity_ID(String City_ID) {
        this.City_ID = City_ID;
    }

    public String getCity_Name() {
        return City_Name;
    }

    public void setCity_Name(String City_Name) {
        this.City_Name = City_Name;
    }
    
    
}
