class RpnPrinter implements Expr.Visitor<String> {

    String print(Expr expr) {
        return expr.accept(this);
    }

    @Override
    public String visitBinaryExpr(Expr.Binary expr) {
        String left = expr.left.accept(this);
        String right = expr.right.accept(this);

        return left + " " + right + " " + expr.operator.lexeme;
    }

    @Override
    public String visitGroupingExpr(Expr.Grouping expr) {
        return expr.expression.accept(this);
    }

    @Override
    public String visitLiteralExpr(Expr.Literal expr) {
        return String.valueOf(expr.value);
    }

    @Override
    public String visitUnaryExpr(Expr.Unary expr) {
        String right = expr.right.accept(this);

        return right + " " + expr.operator.lexeme;
    }
}
