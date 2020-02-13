package football.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import football.repository.AwayteamRepo;

import football.repository.CountryRepo;
import football.repository.FixtureRepo;
import football.repository.HometeamRepo;
import football.repository.LeagueRepo;
import football.repository.RoundRepo;
import football.repository.ScoreRepo;
import football.repository.TeamRepo;
import model.AwayTeam;
import model.Fixture;
import model.HomeTeam;
import model.League;
import model.Round;
import model.Score;
import model.Team;
import modelA.FixtureA;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FixturesController {

	private Param param = new Param();

	@Autowired
	FixtureRepo fixtureRepo;

	@Autowired
	ScoreRepo scoreRepo;

	@Autowired
	RoundRepo roundRepo;

	@Autowired
	LeagueRepo leagueRepo;

	@Autowired
	HometeamRepo homeTeamRepo;

	@Autowired
	AwayteamRepo awayTeamRepo;

	@Autowired
	TeamRepo teamRepo;

	@Autowired
	CountryRepo cr;

	
	@RequestMapping(value = "/getNsFixtures/{idLeague}", method = RequestMethod.GET)
	public List<FixtureA> getNsFixtures(@PathVariable Integer idLeague) {
		List<FixtureA> fixtures = new ArrayList<FixtureA>();
		List<FixtureA> rez = fixtureRepo.getAng(idLeague);

		for (FixtureA f : rez) {
			if (f.getStatusShort().equals("NS")) {

				fixtures.add(f);
			}
		}
		return fixtures;
	}

	@RequestMapping(value = "/getFixtures/{idLeague}", method = RequestMethod.GET)
	public List<FixtureA> getFixtures(@PathVariable Integer idLeague) {

		List<FixtureA> fixtures = new ArrayList<FixtureA>();
		List<FixtureA> rez = fixtureRepo.getAng(idLeague);

		for (FixtureA f : rez) {
			if (f.getStatus().equals("Match Finished") ) {

				fixtures.add(f);
			}
		}

		return fixtures;
	}

	@RequestMapping(value = "/getA", method = RequestMethod.GET)
	public List<FixtureA> getNsFixturesA() {
		return fixtureRepo.getAng(357);
		
	}

}
