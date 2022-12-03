

public class CuentaBanco {

    private double balance; // Balance de la cuenta
    private double ultDeposito;
    private double ultRetiro;
    private String pin; //Pin default
    
    public CuentaBanco() //Constructor
    { 
        pin="0000"; 
        balance =1_000;
        ultDeposito=0;
        ultRetiro=0;
    }
    
    public void setPin(String pin) //Pin set and get methods
    {
        this.pin=pin;
    }
    
    public String getPin()
    {
        return pin;    
    }
    
    public void setBalance(double balance) //Balance set and get methods
    {
        this.balance=balance;    
    }
    
    public double getBalance()
    {
        return balance;
    }
    
    public void setUltimoDeposito(double ultDeposito)//Depostito Set and get
    {
    this.ultDeposito=ultDeposito;
    balance+=ultDeposito;
    }
    
    public double getUltimoDeposito()
    {
        return ultDeposito;
    }
    
    public void setUltimoRetiro(double ultRetiro)//Retiro Set and get
    {
        this.ultRetiro=ultRetiro;
        balance-=ultRetiro;
    }

    
    public double getUltimoRetiro()
    {
        return ultRetiro;
    }
    
    

}//Fin clase
