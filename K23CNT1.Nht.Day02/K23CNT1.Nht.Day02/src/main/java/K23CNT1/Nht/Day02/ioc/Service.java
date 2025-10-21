package K23CNT1.Nht.Day02.ioc;

class Service {
    public void serve() {
        System.out.println("Service is serving");
    }
}

class Client {
    private Service service;

    public Client() {
        // Client TỰ TẠO đối tượng Service (Khớp nối chặt)
        service = new Service();
    }

    public void doSomething() {
        service.serve();
    }
}

class NonIoC {
    public static void main(String[] args) {
        Client client = new Client();
        client.doSomething(); // Output: Service is serving
    }
}