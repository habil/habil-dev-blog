resource "aws_nat_gateway" "nat-1a" {
  allocation_id = aws_eip.nat-1a.id
  subnet_id     = aws_subnet.sn-1a-public-xlb.id
  tags = {
    Name        = "habil-dev-1a-nat-gw"
    Environment = "dev"
    CostCenter  = "habil-dev-1a-nat-gw"
  }
}

resource "aws_nat_gateway" "nat-1b" {
  allocation_id = aws_eip.nat-1b.id

  subnet_id     = aws_subnet.sn-1b-public-xlb.id

  tags = {
    Name        = "habil-dev-1b-nat-gw"
    Environment = "dev"
    CostCenter  = "habil-dev-1b-nat-gw"
  }
}

resource "aws_nat_gateway" "nat-1c" {
  allocation_id = aws_eip.nat-1c.id

  subnet_id     = aws_subnet.sn-1c-public-xlb.id

  tags = {
    Name        = "habil-dev-1c-nat-gw"
    Environment = "dev"
    CostCenter  = "habil-dev-1c-nat-gw"
  }
}

