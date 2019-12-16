package com.hotel.service;

import com.hotel.pojo.Team;

import java.util.List;

public interface TeamService {

    List<Team> getAllTeam();

    Team login(Team t);

    boolean saveTeam(Team t);

    Team getTeamByTid(int tid);

    boolean deleteTeamByTid(int tid);

    boolean updateTeamByTid(Team t);
}