package com.nyist.service;

import com.nyist.pojo.Authority;
import com.nyist.pojo.RoleAuthority;
import com.nyist.pojo.TUser;
import com.nyist.repository.AuthorityRepository;
import com.nyist.repository.RoleAuthorityRepository;
import com.nyist.result.NyistResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2018/7/15/015.
 */
@Service
@Transactional
public class RoleAuthorityServiceImpl implements RoleAuthorityService {    //查找用户权限并排序显示
    @Autowired
    private RoleAuthorityRepository roleAuthorityRepository;
    @Autowired
    private AuthorityRepository authorityRepository;
    @Override
    public NyistResult setUserPower(TUser tUser) {
        List<RoleAuthority> list=roleAuthorityRepository.findAidByRole(tUser.getRole());
        String[] aids=new String[list.size()];
        for(int i=0;i<list.size();i++){
            aids[i]=list.get(i).getAuthorityByAid().getId();
        }
        List<Authority> powerList=authorityRepository.findAuthorityByRole(aids);
        Collections.sort(powerList, new Comparator<Authority>() {
            public int compare(Authority arg0, Authority arg1) {
                int sort0 = arg0.getSorter();
                int sort1 = arg1.getSorter();
                if (sort1 < sort0) {
                    return 1;
                } else if (sort1 == sort0) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        return NyistResult.ok(powerList);
    }
}
