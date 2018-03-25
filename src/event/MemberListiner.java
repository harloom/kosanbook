/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import enity.Member;
import model.MemberModel;


/**
 *
 * @author Hx-loom
 */
public interface MemberListiner {
    
    public void onChange(MemberModel model);
    public void onInsert(Member member);
    public void restetMember(Member member);
}
