resource "aws_eip" "nat-1a" {
  vpc = true
  tags = {
    Name        = "habil-dev-nat-eip-1a"
    Environment = "dev"
    CostCenter  = "habil-dev-nat-eip-1a"
  }
}

resource "aws_eip" "nat-1b" {
  vpc = true
  tags = {
    Name        = "habil-dev-nat-eip-1b"
    Environment = "dev"
    CostCenter  = "habil-dev-nat-eip-1b"
  }
}

resource "aws_eip" "nat-1c" {
  vpc = true
  tags = {
    Name        = "habil-dev-nat-eip-1c"
    Environment = "dev"
    CostCenter  = "habil-dev-nat-eip-1c"
  }
}