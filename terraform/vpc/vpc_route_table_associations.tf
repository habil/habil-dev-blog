resource "aws_route_table_association" "rta-1a-public-xlb" {
  route_table_id = aws_route_table.rt-1a-public-xlb.id
  subnet_id = aws_subnet.sn-1a-public-xlb.id
}

resource "aws_route_table_association" "rta-1b-public-xlb" {
  route_table_id = aws_route_table.rt-1b-public-xlb.id
  subnet_id      = aws_subnet.sn-1b-public-xlb.id
}

resource "aws_route_table_association" "rta-1c-public-xlb" {
  route_table_id = aws_route_table.rt-1c-public-xlb.id
  subnet_id      = aws_subnet.sn-1c-public-xlb.id
}


// Private Generic Subnets

resource "aws_route_table_association" "rta-1a-private-generic" {
  route_table_id = aws_route_table.rt-1a-private-generic.id
  subnet_id      = aws_subnet.sn-1a-private-generic.id
}
resource "aws_route_table_association" "rta-1b-private-generic" {
  route_table_id = aws_route_table.rt-1b-private-generic.id
  subnet_id      = aws_subnet.sn-1b-private-generic.id
}
resource "aws_route_table_association" "rta-1c-private-generic" {
  route_table_id = aws_route_table.rt-1c-private-generic.id
  subnet_id      = aws_subnet.sn-1c-private-generic.id
}


