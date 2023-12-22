package com.security.client.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Calendar;
import java.util.Date;

@Data
@Entity
public class VerificationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String token;

    private Date expirationTime;
    private static int expirationTimeinMin = 10;

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn (
            name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_USER_VERIFY_TOKEN")
    )

    private User user;

   public VerificationToken( User user , String token)
   {
       super();
       this.token=token;
       this.user=user;
       this.expirationTime = calculateExpirationDate(expirationTimeinMin);

   }

    public VerificationToken( String token)
    {
        super();
        this.token=token;
        this.expirationTime = calculateExpirationDate(expirationTimeinMin);

    }


    public Date calculateExpirationDate( int expirationTime)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(new Date().getTime());
        cal.add(Calendar.MINUTE , expirationTime);
        return  new Date(cal.getTime().getTime());
    }
}
