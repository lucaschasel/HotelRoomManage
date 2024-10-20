package main.hotelmanage.DAO;

import main.hotelmanage.model.Hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO {

    public List<Hotel> getAllHotels() throws SQLException, ClassNotFoundException {
        List<Hotel> hotels = new ArrayList<>();
        String query = "SELECT * FROM hotel";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Hotel hotel = new Hotel(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getString("mobile"));
                hotels.add(hotel);
            }
        }
        return hotels;
    }

    public void addHotel(Hotel hotel) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO hotel (name, address, mobile) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(insert)) {
            ps.setString(1, hotel.getName());
            ps.setString(2, hotel.getAddress());
            ps.setString(3, hotel.getMobile());
            ps.executeUpdate();
        }
    }
}
