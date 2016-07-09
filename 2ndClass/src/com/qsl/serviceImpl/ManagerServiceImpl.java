package com.qsl.serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.qsl.mapper.ManagerMapper;
import com.qsl.pojo.Manager;
import com.qsl.pojo.NewManager;
import com.qsl.service.IManagerService;
import com.qsl.status.SystemCode;
import com.qsl.util.FileOperation;

public class ManagerServiceImpl implements IManagerService {

	@Autowired
	private ManagerMapper mapper;
	@Override
	public String login(Map session, Manager manager) {
		Manager m = mapper.selectManagerByName(manager);
		if(m==null){
			return SystemCode.NOT_SUCH_USER;
		}
		if(!m.getPassword().equals(manager.getPassword())){
			return SystemCode.ERROR_PWD;
		}
		session.put("manager", m);
		session.put("role", "manager");
		return SystemCode.SUCCESS;		
	}

	@Override
	public String add(Map session, Manager manager) {
		Manager m = mapper.selectManagerByName(manager);
		Manager mana = mapper.selectManagerByTel(manager);
		
		if(m != null && m.getMname().equals(manager.getMname())){
			return SystemCode.EXIST_USER;
		}
		if(mana != null && mana.getTel().equals(manager.getTel())){
			return SystemCode.EXIST_TEL;
		}
		mapper.insertManager(manager);
		return SystemCode.SUCCESS;
	}

	@Override
	public String findManagerPwd(Manager manager) {
		Manager m = mapper.selectManagerByName(manager);
		if(m == null){
			return SystemCode.NOT_SUCH_USER;
		}
		if(!m.getTel().equals(manager.getTel())){
			return SystemCode.ERROR_TEL;
		}
		return SystemCode.SUCCESS;	
	}

	@Override
	public String updateManagerInfo(Map session, NewManager manager) {		
		Manager man = (Manager) session.get("manager");
		
		if(manager.getNickname()!=null){
			man.setNickname(manager.getNickname());
		}
		
		if(manager.getPic()!=null){
			man.setPic(manager.getPic());
		}
		
		if(manager.getTel()!=null){
			man.setTel(manager.getTel());
		}
		
		if(manager.getLasttime()!=null){
			man.setLasttime(manager.getLasttime());
		}
		
		if(manager.getSex()==0 ||manager.getSex()==1||manager.getSex()==2){
			man.setSex(manager.getSex());
		}
		if (manager.getFile() != null) {
			FileOperation.fileUpload(manager.getFile(), "", "");
			man.setPic(manager.getFile().getName());
		}
		mapper.updateManager(man);
		Manager m = mapper.selectManagerByName(manager);
		session.put(m, manager);
		return SystemCode.INFO_SUCCESS;	
	}

	@Override
	public String exit(Map session) {
		session.clear();
		return SystemCode.SUCCESS;
	}

	@Override
	public String updateManagerPwd(Map session, NewManager manager) {
		Manager man = (Manager) session.get("manager");
		if(manager.getMname()!=null){
			man.setMname(manager.getMname());
		}
		
		if(manager.getOld_password()==null)
		{
			if (manager.getPassword()!=null) {
				
				man.setPassword(manager.getPassword());
				mapper.updateManager(man);
			}
		}
		if(manager.getOld_password()!=null && !manager.getOld_password().equals(man.getPassword())){		
			return SystemCode.ERROR_PWD;
		}
		if(manager.getOld_password()!=null && manager.getOld_password().equals(man.getPassword())){		
			man.setPassword(manager.getPassword());
			mapper.updateManager(man);
		}
		return SystemCode.SUCCESS;				
	}

}
