package grup06_practica3.utils;

public class Settings {

	/**
	 * Key which identifies TEXT_MODE
	 */
	public static final String TEXT_MODE = "text_mode";

	/**
	 * Key which identifies GUI_MODE
	 */
	public static final String GUI_MODE = "gui_mode";

	/**
	 * Key which identifies ADD_PRODUCT
	 */
	public static final int ADD_PRODUCT = 1;

	/**
	 * Key which identifies LOAD_PRODUCTS
	 */
	public static final int LOAD_PRODUCTS = 2;

	/**
	 * Key which identifies REMOVE_PRODUCT
	 */
	public static final int REMOVE_PRODUCT = 3;

	/**
	 * Key which identifies DISPLAY_PRODUCT
	 */
	public static final int DISPLAY_PRODUCT = 4;

	/**
	 * Key which identifies ADD_CLIENT
	 */
	public static final int ADD_CLIENT = 5;

	/**
	 * Key which identifies DISPLAY_CLIENT_ORDERS
	 */
	public static final int DISPLAY_CLIENT_ORDERS = 6;

	/**
	 * Key which identifies ADD_ORDER
	 */
	public static final int ADD_ORDER = 7;

	/**
	 * Key which identifies COPY_ORDER
	 */
	public static final int COPY_ORDER = 8;

	/**
	 * Key which identifies LOAD_CLIENTS_ORDERS
	 */
	public static final int LOAD_CLIENTS_ORDERS = 9;

	/**
	 * Key which identifies SAVE_CLIENTS_ORDERS
	 */
	public static final int SAVE_CLIENTS_ORDERS = 10;

	/**
	 * Key which identifies EXIT
	 */
	public static final int EXIT = 11;

	/**
	 * Key which identifies PRODUCTS_HEADER
	 */
	public static final String PRODUCTS_HEADER = "#Type;Id;Name;Price;Discount;Celica;Lactose;DriedFruits\n";

	/**
	 * Key which identifies CLIENTS_HEADER
	 */
	public static final String CLIENTS_HEADER = "#Id;name;address;username;password;phone_number;celiac;lactose;driedFruits\n";

	/**
	 * Key which identifies ORDERS_HEADER
	 */
	public static final String ORDERS_HEADER = "#Id;ClientId;orderDate;Price;[orderLines]\n";

	/**
	 * Key which identifies the products file path
	 */
	public static final String PRODUCTS_PATH = "products.txt";

	/**
	 * Key which identifies the clients file path
	 */
	public static final String CLIENTS_PATH = "clients.txt";

	/**
	 * Key which identifies the orders file path
	 */
	public static final String ORDERS_PATH = "orders.txt";
}
