terraform {

  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "4.27.0"
    }

    random = {
      source  = "hashicorp/random"
      version = "3.1.0"
    }

  }

  backend "s3" {
    bucket         = "terraform-ninja"
    key            = "global/s3/terraform.tfstate"
    region         = "us-west-2"
    dynamodb_table = "terraform-up-and-running-locks"
    encrypt        = true
  }

  required_version = "~> 1.2.0"
}

