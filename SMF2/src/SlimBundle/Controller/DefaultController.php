<?php

namespace SlimBundle\Controller;


use SlimBundle\Entity\Reclamation;
use SlimBundle\Entity\Vote;
use SlimBundle\Form\ReclamationType;
use SlimBundle\Form\VoteType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

class DefaultController extends Controller
{
    public function indexAction()
    {
        return $this->render('@Slim/Default/index.html.twig');
    }
    public function indexfrontAction()
    {
        return $this->render('@Slim/Default/indexfront.html.twig');
    }

}
