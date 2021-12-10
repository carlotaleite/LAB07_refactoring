package pt.up.fe.ldts.example1;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderLine> lines;

    public Order() {
        lines = new ArrayList<>();
    }

    public void add(Product product, int quantity) {
        lines.add(new OrderLine(product, quantity));
    }

    public boolean isElegibleForFreeDelivery() {
        double total = 0;

        for (OrderLine line : lines)
            total += line.getProduct().getPrice() * line.getQuantity();

        return (total > 100);
    }

    public String printOrder() {
        StringBuffer printBuffer = new StringBuffer();
        double total = 0;

        for (OrderLine line : lines) {
            printBuffer.append(line.getProduct().getName() + "(x" + line.getQuantity()+ "): " + (line.getProduct().getPrice() * line.getQuantity()) + "\n");
            total += line.getProduct().getPrice() * line.getQuantity();
        }

        printBuffer.append("Total: " + total);

        return printBuffer.toString();
    }
}