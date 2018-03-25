/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import enity.Member;
import error.MemberException;
import java.util.List;


/**
 *
 * @author Hx-loom
 */
public interface Service_member_dao {
    
    //memasang metode yang di gunakan;
    public void insertMember(Member member) throws MemberException;
    public List<Member> selectallmember() throws  MemberException;  
}
