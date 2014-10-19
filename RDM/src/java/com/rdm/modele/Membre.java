/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rdm.modele;

/**
 *
 * @author usager
 */
public class Membre {
    private String email,mdp;
	
	//constructeurs
	public Membre(String email, String mdp)
	{
		this.email =email;
		this.mdp = mdp;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
	   this.email = email;	
		
	}
	
	public String getMdp()
	{
		return mdp;
	}
	
	public void setMdp(String mdp)
	{
	   this.mdp = mdp;	
		
	}
	
}
