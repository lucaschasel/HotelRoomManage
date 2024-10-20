package main.hotelmanage.DAO;

import main.hotelmanage.model.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {

    public List<Room> getAllRooms() throws SQLException, ClassNotFoundException {
        List<Room> rooms = new ArrayList<>();
        String query = "SELECT * FROM room";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Room room = new Room(rs.getInt("id"), rs.getInt("type"), rs.getInt("price"), rs.getString("info"), rs.getInt("hotelId"));
                rooms.add(room);
            }
        }
        return rooms;
    }

    public void addRoom(Room room) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO room (type, price, info, hotelId) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(insert)) {

            ps.setInt(1, room.getType());
            ps.setInt(2, room.getPrice());
            ps.setString(3, room.getInfo());
            ps.setInt(4, room.getHotelId());
            ps.executeUpdate();
        }
    }

    public void deleteRoom(int id) throws SQLException, ClassNotFoundException {
        String delete = "DELETE FROM room WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(delete)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
