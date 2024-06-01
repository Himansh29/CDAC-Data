package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import static utils.DBUtils.*;
import entity.Candidate;

public class CandidateDaoImple implements CandidateDao {

	private Connection con;
	private PreparedStatement pst1;
	private PreparedStatement pst2;

	public CandidateDaoImple() throws SQLException {
		con = openConnection();

		pst1 = con.prepareStatement("select * from users where email=? and password=?");
		pst1 = con.prepareStatement("");
	}

	@Override
	public Candidate signIn(String email, String password) throws SQLException {

		pst1.setString(1, email);
		pst1.setString(2, password);

		try (ResultSet resultSet = pst1.executeQuery()) {

			if (resultSet.next()) {
				return new Candidate(resultSet.getInt(1), resultSet.getString(2), email, password);
			}

		}

		return null;
	}

	@Override
	public List<Candidate> getAllCandidates() throws SQLException {
		
		return null;
	}

	@Override
	public String addVoter(Candidate candidate) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteVoter(int voterId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
