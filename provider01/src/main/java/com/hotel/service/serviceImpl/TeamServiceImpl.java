package com.hotel.service.serviceImpl;

import com.hotel.dao.TeamDao;
import com.hotel.pojo.Team;
import com.hotel.service.TeamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TeamServiceImpl implements TeamService {
    @Resource
    private TeamDao teamDao;
    @Override
    public List<Team> getAllTeam() {
        return teamDao.getAllTeam();
    }

    @Override
    public Team login(Team t) {
        return teamDao.login(t);
    }

    @Override
    public boolean saveTeam(Team t) {
        return teamDao.saveTeam(t)>0;
    }

    @Override
    public Team getTeamByTid(int tid) {
        return teamDao.getTeamByTid(tid);
    }

    @Override
    public boolean deleteTeamByTid(int tid) {
        return teamDao.deleteTeamByTid(tid)>0;
    }

    @Override
    public boolean updateTeamByTid(Team t) {
        return teamDao.updateTeamByTid(t)>0;
    }
}
