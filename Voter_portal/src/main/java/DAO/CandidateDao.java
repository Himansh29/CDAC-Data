package DAO;

import java.sql.SQLException;
import java.util.List;

import entity.Candidate;

public interface CandidateDao {

	
	Candidate signIn(String email, String password) throws SQLException; 
	List<Candidate> getAllCandidates() throws SQLException;
	String addVoter(Candidate candidate) throws SQLException;
	String deleteVoter(int voterId) throws SQLException;
}
