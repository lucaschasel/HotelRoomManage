package main.hotelmanage.Controller;

import main.hotelmanage.DAO.RoomDAO;
import main.hotelmanage.model.Room;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class RoomController extends HttpServlet {
    private RoomDAO roomDAO;

    @Override
    public void init() {
        roomDAO = new RoomDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if (action == null) {
                listRooms(request, response);
            } else if (action.equals("add")) {
                showAddRoomForm(request, response);
            } else if (action.equals("insert")) {
                insertRoom(request, response);
            } else if (action.equals("delete")) {
                deleteRoom(request, response);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    private void listRooms(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException, ClassNotFoundException {
        List<Room> rooms = roomDAO.getAllRooms();
        request.setAttribute("rooms", rooms);
        request.getRequestDispatcher("WEB-INF/room-list.jsp").forward(request, response);
    }

    private void showAddRoomForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/room-form.jsp").forward(request, response);
    }

    private void insertRoom(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int type = Integer.parseInt(request.getParameter("type"));
        int price = Integer.parseInt(request.getParameter("price"));
        String info = request.getParameter("info");
        int hotelId = Integer.parseInt(request.getParameter("hotelId"));

        Room newRoom = new Room(type, price, info, hotelId);

        try {
            roomDAO.addRoom(newRoom);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("RoomController");
    }

    private void deleteRoom(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            roomDAO.deleteRoom(id);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("RoomController");
    }
}
